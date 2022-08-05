package ttsw.filopl.cleanjavaarchitecture.project;

import ttsw.filopl.cleanjavaarchitecture.project.dto.SimpleProject;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by T. Filo Zegarlicki on 05.08.2022
 **/

@Entity
@Table(name = "projects")
public class SqlSimpleProject {

    public static SqlSimpleProject fromProject(SimpleProject source) {
        var result = new SqlSimpleProject();
        result.id = source.getId();
        result.name = source.getName();
        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;

    public SimpleProject toProject() {
        return new SimpleProject(id, name);
    }
}
