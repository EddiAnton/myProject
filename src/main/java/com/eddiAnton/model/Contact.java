package com.eddiAnton.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contact_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "contactType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Phone.class, name = "PHONE"),
        @JsonSubTypes.Type(value = Email.class, name = "EMAIL"),
        @JsonSubTypes.Type(value = Address.class, name = "ADDRESS")
})
public abstract class Contact {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_uuid")
    @JsonIgnore
    private Person person;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type", insertable = false, updatable = false)
    protected ContactType contactType;

    @PrePersist
    protected void prePersist() {
        if (this.contactType == null) {
            this.contactType = getContactType();
        }
    }

    public abstract ContactType getContactType();
}
