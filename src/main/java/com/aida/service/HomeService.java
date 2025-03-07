package com.aida.service;

import com.aida.model.Home;
import com.aida.model.HomeCategory;

import java.util.List;

public interface HomeService {
    public Home createHomePageData(List<HomeCategory> allCategories);
}
