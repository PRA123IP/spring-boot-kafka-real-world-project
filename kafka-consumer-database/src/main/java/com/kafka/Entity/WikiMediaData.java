package com.kafka.Entity;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name="wikimedia")
@Getter
@Setter
public class WikiMediaData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @Lob
    private String wikiEventData;

}
