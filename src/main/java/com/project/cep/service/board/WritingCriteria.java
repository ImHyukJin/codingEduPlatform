package com.project.cep.service.board;



import lombok.Data;


@Data
public class WritingCriteria {
    private Integer currentPage;
    private Integer writing;

    public WritingCriteria(){
        this(1,5);
    }

    public WritingCriteria(Integer currentPage, Integer writing) {
        this.currentPage = currentPage;
        this.writing = writing;
    }

    public Integer getStartPage(){
        return  (currentPage - 1) * writing ;
    }

}
