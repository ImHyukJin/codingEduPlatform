package com.project.cep.service.edu;



import lombok.Data;


@Data
public class ShowCriteria {
    private Integer currentPage;
    private Integer showPage;

    public ShowCriteria(){
        this(1,10);
    }

    public ShowCriteria(Integer currentPage, Integer showPage) {
        this.currentPage = currentPage;
        this.showPage = showPage;
    }

    public Integer getStartPage(){
        return  (currentPage - 1) * 10 ;
    }

}
