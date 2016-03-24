package com.example.maoyh.tctest.jsonBean;

import java.util.List;

/**
 * Created by MAOYH on 2016/3/21.
 */
public  class JsonDriver {
    /**
     * count : 72165
     * dataList : [{"carNo":"测试内容pe85","code":"测试内容vrso","endStation":"测试内容4dp5","finishDate":"1979-08-13","hasVolume":26764,"hasWeight":48853,"loadingPointList":[{"loadingPoint":"测试内容1540"}],"status":68174}]
     * page : 22316
     * totalCount : 44185
     */

    private int count;
    private int page;
    private int totalCount;
    /**
     * carNo : 测试内容pe85
     * code : 测试内容vrso
     * endStation : 测试内容4dp5
     * finishDate : 1979-08-13
     * hasVolume : 26764
     * hasWeight : 48853
     * loadingPointList : [{"loadingPoint":"测试内容1540"}]
     * status : 68174
     */

    private List<DataListBean> dataList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        private String carNo;
        private String code;
        private String endStation;
        private String finishDate;
        private int hasVolume;
        private int hasWeight;

        @Override
        public String toString() {
            return "DataListBean{" +
                    "carNo='" + carNo + '\'' +
                    ", code='" + code + '\'' +
                    ", endStation='" + endStation + '\'' +
                    ", finishDate='" + finishDate + '\'' +
                    ", hasVolume=" + hasVolume +
                    ", hasWeight=" + hasWeight +
                    ", status=" + status +
                    ", loadingPointList=" + loadingPointList +
                    '}';
        }

        private int status;
        /**
         * loadingPoint : 测试内容1540
         */

        private List<LoadingPointListBean> loadingPointList;

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public String getFinishDate() {
            return finishDate;
        }

        public void setFinishDate(String finishDate) {
            this.finishDate = finishDate;
        }

        public int getHasVolume() {
            return hasVolume;
        }

        public void setHasVolume(int hasVolume) {
            this.hasVolume = hasVolume;
        }

        public int getHasWeight() {
            return hasWeight;
        }

        public void setHasWeight(int hasWeight) {
            this.hasWeight = hasWeight;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

    @Override
    public String toString() {
        return "JsonDriver{" +
                "count=" + count +
                ", page=" + page +
                ", totalCount=" + totalCount +
                ", dataList=" + dataList +
                '}';
    }
//    public abstract class DriverCallback extends Callback<JsonDriver>
//    {
//        @Override
//        public JsonDriver parseNetworkResponse(Response response) throws IOException
//        {
//            String string= response.body().string();
//            JsonDriver mJsonDriver = new Gson().fromJson(string, JsonDriver.class);
//            return mJsonDriver;
//        }
//    }
}
