package edu.ynu.ecs.service;
    
    


import edu.ynu.ecs.service.AbstractTypedService;
import java.lang.String;
import edu.ynu.ecs.entities.Shop;
import edu.ynu.ecs.service.ShopService;
import edu.ynu.ecs.dao.ShopDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
/**
 * 业务层
 *
 * @author shiwenbo
 * @since 2023-01-08 23:49:10
 */
@Slf4j
@Service
public class ShopService extends AbstractTypedService<Shop, String> {

	@Resource
    private ShopDao shopDao;

    public ShopService(ShopDao dao) {
        this.dataContext = dao;
        this.shopDao = dao;
    }

    public Page<Shop> queryShopByPage(Pageable page) {
        return shopDao.queryPage(page, null);
    }

}

