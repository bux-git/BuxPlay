package com.example.lym.buxplay.bean;

import java.util.List;

/**
 * @description：
 * @author：bux on 2018/3/20 16:33
 * @email: 471025316@qq.com
 */

public class FollowList {


    /**
     * data : {"endRow":20,"firstPage":1,"hasNextPage":true,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":false,"lastPage":8,"list":[{"fans":526,"follow":1,"follows":526,"userIcon":"img/42ce0671cf4c3300a7a2f5969dcf2c8b.jpeg","userId":3099,"userName":"btc100861","valid":1},{"fans":469,"follow":1,"follows":469,"userIcon":"img/c7e85d1d40d4431fb73abf41f4ca003b.jpg","userId":3237,"userName":"认真的鱼","valid":1},{"fans":185,"follow":1,"follows":185,"userIcon":"img/d6fa19b7edea640019feacf19f086228.jpeg","userId":3595,"userName":"燭光","valid":1},{"fans":848,"follow":1,"follows":848,"userIcon":"img/68d3e5a3f814e4da2c9de3e69a14067b.jpeg","userId":4093,"userName":"来自J7的小韭韭","valid":1},{"fans":143,"follow":1,"follows":143,"userIcon":"img/142bb2abd882c18d2b860da2e73307bc.jpeg","userId":4622,"userName":"阿牛牛","valid":1},{"fans":444,"follow":1,"follows":444,"userIcon":"img/0c3057450891dff4cc2989e80bb9a8db.jpeg","userId":4642,"userName":"币友_14740","valid":1},{"fans":1128,"follow":1,"follows":1128,"userIcon":"img/9a1390115e979b32ddd08b1d35a54c6b.jpeg","userId":11378,"userName":"凉风有刃","valid":1},{"fans":1414,"follow":1,"follows":1414,"userIcon":"img/511376dc7eb0ccb949b7cacee5c9256d.jpeg","userId":12650,"userName":"币赚道","valid":1},{"fans":108,"follow":1,"follows":108,"userIcon":"img/c73a1e20e0384396ebf5f2835c17a07b.jpeg","userId":13508,"userName":"觉醒君大大","valid":1},{"fans":1250,"follow":1,"follows":1250,"userIcon":"img/edc679d94573fa228163495ccf6e452e.jpeg","userId":15233,"userName":"森淼","valid":1},{"fans":919,"follow":1,"follows":919,"userIcon":"img/68ce9b2106c02c17f0a7adac319df1a5.jpeg","userId":17380,"userName":"区块链投资者","valid":1},{"fans":1392,"follow":1,"follows":1392,"userIcon":"img/54b33856e307889f2e1804ddb1b6de12.jpeg","userId":18528,"userName":"剑仙","valid":1},{"fans":822,"follow":1,"follows":822,"userIcon":"img/bihu_user_default_icon.png","userId":19849,"userName":"币圈伟哥","valid":1},{"fans":829,"follow":1,"follows":829,"userIcon":"img/c239bb74df9b96c83fbad7b3d431ed70.jpeg","userId":24661,"userName":"币圈巴比特","valid":1},{"fans":523,"follow":1,"follows":523,"userIcon":"img/827a0a1ed9b7624378d8a0abf2659c23.jpeg","userId":33016,"userName":"cqyfy","valid":1},{"fans":113,"follow":1,"follows":113,"userIcon":"img/7dc87b5834b585958214c27ce9d3f989.jpeg","userId":74564,"userName":"中國風","valid":1},{"fans":48,"follow":1,"follows":48,"userIcon":"img/1048c9f1d8c934aea0d8892d0a52096d.jpeg","userId":84794,"userName":"腹黑兔兔","valid":1},{"fans":586,"follow":1,"follows":586,"userIcon":"img/873c84f8e3939482fa8e146cdaa83199.jpeg","userId":224776,"userName":"红豆","valid":1},{"fans":602,"follow":1,"follows":602,"userIcon":"img/81719340c7b14c167153e26bc1f58cea.jpeg","userId":231810,"userName":"BEAT","valid":1},{"fans":20,"follow":1,"follows":20,"userIcon":"img/bc66fd3892f31e8d8f56cf5754cec67f.jpeg","userId":257594,"userName":"币友_264870","valid":1}],"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7,8],"nextPage":2,"pageNum":1,"pageSize":20,"pages":16,"prePage":0,"size":20,"startRow":1,"total":316}
     * res : 1
     * resMsg : success
     */

    private DataBean data;
    private int res;
    private String resMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public static class DataBean {
        /**
         * endRow : 20
         * firstPage : 1
         * hasNextPage : true
         * hasPreviousPage : false
         * isFirstPage : true
         * isLastPage : false
         * lastPage : 8
         * list : [{"fans":526,"follow":1,"follows":526,"userIcon":"img/42ce0671cf4c3300a7a2f5969dcf2c8b.jpeg","userId":3099,"userName":"btc100861","valid":1},{"fans":469,"follow":1,"follows":469,"userIcon":"img/c7e85d1d40d4431fb73abf41f4ca003b.jpg","userId":3237,"userName":"认真的鱼","valid":1},{"fans":185,"follow":1,"follows":185,"userIcon":"img/d6fa19b7edea640019feacf19f086228.jpeg","userId":3595,"userName":"燭光","valid":1},{"fans":848,"follow":1,"follows":848,"userIcon":"img/68d3e5a3f814e4da2c9de3e69a14067b.jpeg","userId":4093,"userName":"来自J7的小韭韭","valid":1},{"fans":143,"follow":1,"follows":143,"userIcon":"img/142bb2abd882c18d2b860da2e73307bc.jpeg","userId":4622,"userName":"阿牛牛","valid":1},{"fans":444,"follow":1,"follows":444,"userIcon":"img/0c3057450891dff4cc2989e80bb9a8db.jpeg","userId":4642,"userName":"币友_14740","valid":1},{"fans":1128,"follow":1,"follows":1128,"userIcon":"img/9a1390115e979b32ddd08b1d35a54c6b.jpeg","userId":11378,"userName":"凉风有刃","valid":1},{"fans":1414,"follow":1,"follows":1414,"userIcon":"img/511376dc7eb0ccb949b7cacee5c9256d.jpeg","userId":12650,"userName":"币赚道","valid":1},{"fans":108,"follow":1,"follows":108,"userIcon":"img/c73a1e20e0384396ebf5f2835c17a07b.jpeg","userId":13508,"userName":"觉醒君大大","valid":1},{"fans":1250,"follow":1,"follows":1250,"userIcon":"img/edc679d94573fa228163495ccf6e452e.jpeg","userId":15233,"userName":"森淼","valid":1},{"fans":919,"follow":1,"follows":919,"userIcon":"img/68ce9b2106c02c17f0a7adac319df1a5.jpeg","userId":17380,"userName":"区块链投资者","valid":1},{"fans":1392,"follow":1,"follows":1392,"userIcon":"img/54b33856e307889f2e1804ddb1b6de12.jpeg","userId":18528,"userName":"剑仙","valid":1},{"fans":822,"follow":1,"follows":822,"userIcon":"img/bihu_user_default_icon.png","userId":19849,"userName":"币圈伟哥","valid":1},{"fans":829,"follow":1,"follows":829,"userIcon":"img/c239bb74df9b96c83fbad7b3d431ed70.jpeg","userId":24661,"userName":"币圈巴比特","valid":1},{"fans":523,"follow":1,"follows":523,"userIcon":"img/827a0a1ed9b7624378d8a0abf2659c23.jpeg","userId":33016,"userName":"cqyfy","valid":1},{"fans":113,"follow":1,"follows":113,"userIcon":"img/7dc87b5834b585958214c27ce9d3f989.jpeg","userId":74564,"userName":"中國風","valid":1},{"fans":48,"follow":1,"follows":48,"userIcon":"img/1048c9f1d8c934aea0d8892d0a52096d.jpeg","userId":84794,"userName":"腹黑兔兔","valid":1},{"fans":586,"follow":1,"follows":586,"userIcon":"img/873c84f8e3939482fa8e146cdaa83199.jpeg","userId":224776,"userName":"红豆","valid":1},{"fans":602,"follow":1,"follows":602,"userIcon":"img/81719340c7b14c167153e26bc1f58cea.jpeg","userId":231810,"userName":"BEAT","valid":1},{"fans":20,"follow":1,"follows":20,"userIcon":"img/bc66fd3892f31e8d8f56cf5754cec67f.jpeg","userId":257594,"userName":"币友_264870","valid":1}]
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6,7,8]
         * nextPage : 2
         * pageNum : 1
         * pageSize : 20
         * pages : 16
         * prePage : 0
         * size : 20
         * startRow : 1
         * total : 316
         */

        private int endRow;
        private int firstPage;
        private boolean hasNextPage;
        private boolean hasPreviousPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private int lastPage;
        private int navigatePages;
        private int nextPage;
        private int pageNum;
        private int pageSize;
        private int pages;
        private int prePage;
        private int size;
        private int startRow;
        private int total;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * fans : 526
             * follow : 1
             * follows : 526
             * userIcon : img/42ce0671cf4c3300a7a2f5969dcf2c8b.jpeg
             * userId : 3099
             * userName : btc100861
             * valid : 1
             */

            private int fans;
            private int follow;
            private int follows;
            private String userIcon;
            private int userId;
            private String userName;
            private int valid;

            public int getFans() {
                return fans;
            }

            public void setFans(int fans) {
                this.fans = fans;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getFollows() {
                return follows;
            }

            public void setFollows(int follows) {
                this.follows = follows;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public int getValid() {
                return valid;
            }

            public void setValid(int valid) {
                this.valid = valid;
            }
        }
    }
}
