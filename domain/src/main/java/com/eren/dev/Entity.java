package com.eren.dev;

import com.eren.dev.events.DomainEvent;
import com.eren.dev.events.DomainEventPublisher;
import com.eren.dev.validation.ValidationHandler;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
public abstract class Entity<ID extends Identifier> {

    protected final ID id;
    private final List<DomainEvent> domainEvents;

    protected Entity(final ID id) {
        this(id, null);
    }

    protected Entity(final ID id, final List<DomainEvent> domainEventListS){
        Objects.requireNonNull(id, "'id' não pode ser nulo");
        this.id = id;
        this.domainEvents = new ArrayList<>(domainEventListS == null ? Collections.emptyList() : domainEventListS);
    }

    public abstract void validate(ValidationHandler handler);

    public ID getId(){
        return id;
    }

    public List<DomainEvent> getDomainEvents(){
        return Collections.unmodifiableList(domainEvents);
    }

    public void publishDomainEvents(final DomainEventPublisher publisher){
        if (publisher == null){
            return;
        }

        getDomainEvents()
                .forEach(publisher::publishEvent);

        this.domainEvents.clear();
    }

    public void registerEvent(final DomainEvent event){
        if (event == null){
            return;
        }
        this.domainEvents.add(event);
    }
}
