package com.gsm.platfra.api.data.platfra.category;

import com.gsm.platfra.api.data.base.BaseEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_PLATFRA_CATEGORY")
public class TPlatfraCategory extends BaseEntity {
    @EmbeddedId
    private TPlatfraCategoryId id;
    
//    @MapsId("platfraId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "PLATFRA_ID", nullable = false)
//    private TPlatfra platfra;
    
}