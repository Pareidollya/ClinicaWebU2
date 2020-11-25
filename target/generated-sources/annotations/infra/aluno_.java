package infra;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-19T22:44:57")
@StaticMetamodel(aluno.class)
public class aluno_ extends nota_ {

    public static volatile SingularAttribute<aluno, String> curso;
    public static volatile SingularAttribute<aluno, Long> id;
    public static volatile SingularAttribute<aluno, String> dataNascimento;
    public static volatile SingularAttribute<aluno, String> sexo;
    public static volatile SingularAttribute<aluno, String> status;

}