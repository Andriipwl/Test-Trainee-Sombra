package app.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.context.annotation.Bean;


public class AnswerStatisticForGenre {
    private String name;
    private long count;

    public AnswerStatisticForGenre() {
    }

    public AnswerStatisticForGenre(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCnt() {
        return count;
    }

    public void setCnt(long count) {
        this.count = count;
    }


}
