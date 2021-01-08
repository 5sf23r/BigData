package cn.tedu.service.aaa;

import org.springframework.stereotype.Service;

@Service
public class ProdServiceImpl implements ProdService {
    @Override
    public void addProd() {
        System.out.println("增加商品");
    }

    @Override
    public void delProd() {
        System.out.println("删除商品");
    }
}
