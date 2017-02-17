package org.v8LogScanner.scanProfilesRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.v8LogScanner.genericRepository.QuerySpecification;

public class ScanProfileSpecByID implements QuerySpecification<ScanProfileHib> {
  
  private int id;
  
  public ScanProfileSpecByID(int id) {
    this.id = id;
  }
  
  @Override
  public boolean specified(ScanProfileHib profile) {
    return id == profile.getId();
  }
  
  public CriteriaQuery<ScanProfileHib> toCriteria(CriteriaBuilder builder) {
    
    CriteriaQuery<ScanProfileHib> criteria = builder.createQuery(ScanProfileHib.class);
    Root<ScanProfileHib> root = criteria.from(ScanProfileHib.class);
    
    criteria.where(builder.equal(root.get("id"), id));
    criteria.select(root);

    return criteria;
  }
}