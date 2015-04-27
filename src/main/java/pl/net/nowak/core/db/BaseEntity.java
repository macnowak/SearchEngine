package pl.net.nowak.core.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

}
