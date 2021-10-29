package com.epam.cleandesign.dip.dao;

import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;

public interface NewsArticleDAO {
    List<NewsArticleTable> findByNewsType(String newsType);
}
