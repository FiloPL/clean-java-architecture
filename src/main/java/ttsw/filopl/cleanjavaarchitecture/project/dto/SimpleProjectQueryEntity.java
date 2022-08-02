package ttsw.filopl.cleanjavaarchitecture.project.dto;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;



/**
 * Created by T. Filo Zegarlicki on 01.08.2022
 **/
@Entity
@Table(name = "projects")
public class SimpleProjectQueryEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;

    //@PersistenceConstructor
    public SimpleProjectQueryEntity() {
    }

    public SimpleProjectQueryEntity(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

