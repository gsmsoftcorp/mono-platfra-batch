package com.gsm.platfra.api.data.base;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class AuditBaseEntityListener {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PreUpdate
	public void beforeAnyUpdate(Object object) {
		if(object instanceof AuditBaseEntity) {
			Assert.notNull(object, "Entity must not be null.");
			((AuditBaseEntity)object).setModUserId("BatchUser");
		}
	}
	
	@PrePersist
	public void prePersist(Object object) {
		if(object instanceof AuditBaseEntity) {
			Assert.notNull(object, "Entity must not be null.");
			((AuditBaseEntity)object).setRegUserId("BatchUser");
			((AuditBaseEntity)object).setModUserId("BatchUser");
		}
	}
}
