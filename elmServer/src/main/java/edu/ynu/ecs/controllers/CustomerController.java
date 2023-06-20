package edu.ynu.ecs.controllers;

import edu.ynu.ecs.controllers.AbstractTypedController;
import edu.ynu.ecs.entities.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import edu.ynu.ecs.service.CustomerService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "顾客控制器 V1", description = "顾客相关接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController extends AbstractTypedController<Customer, String> {
    @Resource
    CustomerService customerService;


//     TODO: 如何做到一个controller调用多个service？
    CustomerController(CustomerService service) {
        this.svcContext = service;
        this.customerService = service;
    }

    @Operation(summary = "顾客修改密码方法")
    @Parameter(name = "username", description = "顾客名", required = true)
    @Parameter(name = "password", description = "密码", required = true)
    @Parameter(name = "newPassword", description = "新密码", required = true)
    @GetMapping("/changePassword")
    public Customer changePassword(String username, String password, String newPassword) {
        return customerService.changePassword(username, password, newPassword);
    }

    @Operation(summary = "顾客查看商品列表方法(分页)")
    @Parameter(name = "pageIndex", description = "页码", required = true)
    @Parameter(name = "pageSize", description = "每页数量", required = true)
    @GetMapping("/menu")
    public Page<Item> menu(int pageIndex, int pageSize) {
        return customerService.menu(pageIndex, pageSize);
    }

    @Operation(summary = "顾客查看商家列表方法(分页)")
    @Parameter(name = "pageIndex", description = "页码", required = true)
    @Parameter(name = "pageSize", description = "每页数量", required = true)
    @GetMapping("/businessList")
    public Page<Business> businessList(int pageIndex, int pageSize) {
        return customerService.businessList(pageIndex, pageSize);
    }

    @Operation(summary = "顾客添加订单项")
    @Parameter(name = "id", description = "顾客id", required = true)
    @Parameter(name = "orderId", description = "订单id", required = true)
    @Parameter(name = "itemId", description = "商品id", required = true)
    @Parameter(name = "quantity", description = "数量", required = true)
    @GetMapping("/addLineItem")
    public LineItem addLineItem(String id, String orderId, String itemId, int quantity) {
        return customerService.addLineItem(id, orderId, itemId, quantity);
    }

	@Operation(summary = "顾客从商店选择商品", security ={
			@SecurityRequirement(name = "Authorization")
		})
	@PostMapping("/buy/{customerId}/{shopId}/{itemId}/{quantity}")
	public LineItem selectItem(@PathVariable String customerId, @PathVariable String shopId, @PathVariable String itemId, @PathVariable int quantity) {
		return customerService.selectItem(customerId, shopId, itemId, quantity);
	}

	@Operation(summary = "顾客查看订单项列表方法")
	@GetMapping("/lineItemList/{orderId}")
	public List<LineItem> lineItemList(@PathVariable String orderId) {
		return customerService.lineItemList(orderId);
	}


	@Operation(summary = "顾客删除订单项方法")
	@Parameter(name = "id", description = "顾客id", required = true)
	@Parameter(name = "orderId", description = "订单id", required = true)
	@Parameter(name = "itemId", description = "商品id", required = true)
	@GetMapping("/deleteLineItem")
	public LineItem deleteLineItem(String id, String orderId, String itemId) {
		return customerService.deleteLineItem(id, orderId, itemId);
	}

	@Operation(summary = "顾客查看所有订单", security ={
			@SecurityRequirement(name = "Authorization")
		})
	@GetMapping("/orderList/{customerId}/{orderId}")
	public List<Order> orderList(@PathVariable String customerId, @PathVariable String orderId) {
		return customerService.orderList(customerId, orderId);
	}



}
