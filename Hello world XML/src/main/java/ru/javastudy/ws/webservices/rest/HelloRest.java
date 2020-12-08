package ru.javastudy.ws.webservices.rest;

import ru.javastudy.ws.model.Document;
import ru.javastudy.ws.model.Goods;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created for JavaStudy.ru on 11.06.2016.
 */
public class HelloRest {

    public HelloRest() {}

    @GET
    @Path("/getgoods")
    @Produces("application/xml")
    public Goods getGoods() {
        Goods goods = new Goods();
        goods.setName("Some Goods name");
        goods.setId(1);
        return goods;
    }

    @GET
    @Path("/getdoc")
    @Produces("application/xml")
    public Document getDocument() {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods(1, "goods1"));
        goodsList.add(new Goods(2, "goods2"));
        goodsList.add(new Goods(3, "goods3"));
        return new Document(777, "firstDocument", goodsList);
    }
}
