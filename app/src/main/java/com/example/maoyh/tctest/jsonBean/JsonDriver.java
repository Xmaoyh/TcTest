package com.example.maoyh.tctest.jsonBean;

import java.util.List;

/**
 * Created by MAOYH on 2016/3/21.
 */
public class JsonDriver {
    /**
     * count : 53523
     * totalCount : 54072
     * dataList : [{"loadingPointList":[{"loadingPoint":"测试内容lduf"}],"status":16020,"endStation":"测试内容en7b","hasWeight":12573,"finishDate":"@date","code":"测试内容673q","hasVolume":75882,"carNo":"测试内容v3x7"}]
     * page : 31140
     */

    private int count;
    private int totalCount;
    private int page;
    /**
     * loadingPointList : [{"loadingPoint":"测试内容lduf"}]
     * status : 16020
     * endStation : 测试内容en7b
     * hasWeight : 12573
     * finishDate : @date
     * code : 测试内容673q
     * hasVolume : 75882
     * carNo : 测试内容v3x7
     */

    private List<DataListBean> dataList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        private int status;
        private String endStation;
        private int hasWeight;
        private String finishDate;
        private String code;
        private int hasVolume;
        private String carNo;
        /**
         * loadingPoint : 测试内容lduf
         */

        private List<LoadingPointListBean> loadingPointList;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public int getHasWeight() {
            return hasWeight;
        }

        public void setHasWeight(int hasWeight) {
            this.hasWeight = hasWeight;
        }

        public String getFinishDate() {
            return finishDate;
        }

        public void setFinishDate(String finishDate) {
            this.finishDate = finishDate;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getHasVolume() {
            return hasVolume;
        }

        public void setHasVolume(int hasVolume) {
            this.hasVolume = hasVolume;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public List<LoadingPointListBean> getLoadingPointList() {
            return loadingPointList;
        }

        public void setLoadingPointList(List<LoadingPointListBean> loadingPointList) {
            this.loadingPointList = loadingPointList;
        }

        public static class LoadingPointListBean {
            private String loadingPoint;

            public String getLoadingPoint() {
                return loadingPoint;
            }

            public void setLoadingPoint(String loadingPoint) {
                this.loadingPoint = loadingPoint;
            }
        }
    }

}
