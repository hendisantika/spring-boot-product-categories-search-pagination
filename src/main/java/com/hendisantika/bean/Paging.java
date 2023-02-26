package com.hendisantika.bean;

import com.hendisantika.enums.PageItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/26/23
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paging {

    private static final int PAGINATION_STEP = 3;

    private boolean nextEnabled;
    private boolean prevEnabled;
    private int pageSize;
    private int pageNumber;

    private List<PageItem> items = new ArrayList<>();

    public void addPageItems(int from, int to, int pageNumber) {
        for (int i = from; i < to; i++) {
            items.add(PageItem.builder().active(pageNumber != i).index(i).pageItemType(PageItemType.PAGE).build());
        }
    }

    public void last(int pageSize) {
        items.add(PageItem.builder().active(false).pageItemType(PageItemType.DOTS).build());
        items.add(PageItem.builder().active(true).index(pageSize).pageItemType(PageItemType.PAGE).build());
    }
}
