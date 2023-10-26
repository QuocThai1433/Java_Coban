package com.example.demo.repository;

import com.example.demo.dto.QueryStudentRequest;
import com.example.demo.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentRepositoryCustomImpl implements IStudentRepositoryCustom {
    private static final List<String> sortList = List.of(
        "name",
        "age",
        "address",
        "score",
        "dateMonth"
    );

    private final EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Students> getByFilter(Sort.Direction nameSortType) {
        String query = "SELECT st FROM students st ORDER BY st.name";
        if (Sort.Direction.ASC.equals(nameSortType)) {
            query = query + " " + Sort.Direction.ASC.name();
        } else {
            query = query + " " + Sort.Direction.DESC.name();
        }
        Query typedQuery = entityManager.createNativeQuery(query, Students.class);
        return typedQuery.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Students> query(QueryStudentRequest request) {
        String query = "select * " +
            "from students " +
            "where if(:name is null, true, name like concat('%', :name, '%')) " +
            "  and if(:age is null, true, age = :age) " +
            "  and if(:score is null, true, score = :score) " +
            "  and if(:address is null, true, address = :address) ";

        query = this.buildSort(query, List.of(request.getSorts()));

        Query typeQuery = entityManager.createNativeQuery(query, Students.class)
            .setParameter("name", request.getFullName())
            .setParameter("age", request.getAge())
            .setParameter("score", request.getScore())
            .setParameter("address", request.getAddress());

        return typeQuery.getResultList();
    }

    private String buildSort(String query, List<String> sorts) {
        if (sorts.isEmpty()) {
            return query;
        }
        StringBuilder queryBuilder = new StringBuilder(query);

        queryBuilder.append("order by ");

        for (String item : sorts) {
            String propertyName = item.split(" ")[0];
            if (sortList.contains(propertyName)) {
                queryBuilder.append(item).append(", ");
            }
        }
        queryBuilder.deleteCharAt(queryBuilder.length() - 1);
        queryBuilder.deleteCharAt(queryBuilder.length() - 1);
        return queryBuilder.toString();
    }
}
