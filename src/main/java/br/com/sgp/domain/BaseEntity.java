package br.com.sgp.domain;

import java.io.Serializable;

public abstract class BaseEntity<I extends Serializable> implements Serializable {
    private static final long serialVersionUID = 3652475876434812990L;

    public abstract I getId();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        String entidade = this.getClass().getSimpleName();
        return "Entidade [ " + entidade + " ] {" + "id=" + getId() + '}';
    }
}