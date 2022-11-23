package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CountReturnBo {
    private List<String> xData;
    private List<Integer> yData;
}
