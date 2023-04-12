package quarkus.example;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class StudentRepository implements PanacheRepository<Students> {

}
