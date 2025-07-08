package com.app.fortuneappcompany.chat.async;

public interface iOnDataFetched {
    void showProgressBar(int progress);

    void hideProgressBar();

    void setDataInPageWithResult(Object result);
}