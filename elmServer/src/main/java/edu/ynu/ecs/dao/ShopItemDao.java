package edu.ynu.ecs.dao;
    
    


import edu.ynu.ecs.dao.AbstractDao;
import java.lang.String;
import edu.ynu.ecs.entities.ShopItem;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 *
 * @author shiwenbo
 * @since 2023-01-02 00:17:05
 */
@Repository
public interface ShopItemDao extends AbstractDao<ShopItem, String> {

}

