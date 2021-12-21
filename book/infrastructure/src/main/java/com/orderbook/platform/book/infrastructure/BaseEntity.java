package com.orderbook.platform.book.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Builder
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @Column(name = "created_date",columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @JsonIgnore
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @JsonIgnore
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0")
    private boolean deleted;

//    public BaseEntity() {}


}
