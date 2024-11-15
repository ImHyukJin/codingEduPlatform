package com.project.cep.service.board;



import lombok.Data;


@Data
public class Criteria {
    private Integer currentPage;
    private Integer writing;

    public Criteria(){
        this(1,5);
    }

    public Criteria(Integer currentPage, Integer writing) {
        this.currentPage = currentPage;
        this.writing = writing;
    }

    public Integer getStartPage(){
        return  (currentPage - 1) * writing ;
    }

}
