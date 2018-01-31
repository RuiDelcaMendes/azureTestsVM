package com.generatedEntities;
// Generated Jan 29, 2018 10:39:56 PM by Hibernate Tools 5.1.6.Final


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Car.
 * @see com.generatedEntities.Car
 * @author Hibernate Tools
 */
@Stateless
public class CarHome {

    private static final Log log = LogFactory.getLog(CarHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Car transientInstance) {
        log.debug("persisting Car instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Car persistentInstance) {
        log.debug("removing Car instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Car merge(Car detachedInstance) {
        log.debug("merging Car instance");
        try {
            Car result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Car findById( String id) {
        log.debug("getting Car instance with id: " + id);
        try {
            Car instance = entityManager.find(Car.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

