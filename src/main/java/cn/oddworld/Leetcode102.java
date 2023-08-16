package cn.oddworld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>  rsp = new ArrayList<>();
        if(root == null){
            return rsp;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){

            List<Integer> tempRsp = new ArrayList<>();
            int size = linkedList.size();
            for(int i = 0; i < size;i++){
                TreeNode poll = linkedList.poll();
                tempRsp.add(poll.val);
                if(poll.left != null){
                    linkedList.add(poll.left);
                }

                if(poll.right != null){
                    linkedList.add(poll.right);
                }
            }
            rsp.add(tempRsp);
        }

        return rsp;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {

        LinkedList<List<Integer>>  rsp = new LinkedList<>();
        if(root == null){
            return rsp;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){

            List<Integer> tempRsp = new ArrayList<>();
            int size = linkedList.size();
            for(int i = 0; i < size;i++){
                TreeNode poll = linkedList.poll();
                tempRsp.add(poll.val);
                if(poll.left != null){
                    linkedList.add(poll.left);
                }

                if(poll.right != null){
                    linkedList.add(poll.right);
                }
            }
            rsp.addFirst(tempRsp);
        }

        return rsp;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>>  rsp = new ArrayList<>();
        if(root == null){
            return rsp;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        boolean flag = true;
        while (!linkedList.isEmpty()){

            LinkedList<Integer> tempRsp = new LinkedList<>();
            int size = linkedList.size();
            for(int i = 0; i < size;i++){
                TreeNode poll = linkedList.poll();
                if(flag){
                   tempRsp.add(poll.val);
                }else {
                    tempRsp.addFirst(poll.val);
                }
                if(poll.left != null){
                    linkedList.add(poll.left);
                }

                if(poll.right != null){
                    linkedList.add(poll.right);
                }
            }
            flag = !flag;
            rsp.add(tempRsp);
        }

        return rsp;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println(linkedList);
    }
}


   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }



/**
 * private void bulk(BulkRequest request) {
 *         //设置数据刷新策略
 *         request.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE);
 *
 *         Map<String, String> mdcMap = MapUtil.emptyIfNull(MDC.getCopyOfContextMap());
 *         //批量插入es
 *         restHighLevelClient.bulkAsync(request, DEFAULT, new ActionListener<BulkResponse>() {
 *             @Override
 *             public void onResponse(BulkResponse bulkItemResponses) {
 *                 MDC.setContextMap(mdcMap);
 *                 BulkItemResponse[] items = bulkItemResponses.getItems();
 *                 boolean errorDataFlag = false;
 *                 for (BulkItemResponse item : items) {
 *                     if (item.isFailed()) {
 *                         log.error("批量插入出现异常，docId={},异常原因：{}", item.getId(), item.getFailureMessage());
 *                         errorDataFlag = true;
 *                     }
 *                 }
 *                 //有错误写入文件
 *                 if (errorDataFlag) {
 *                     writeLog(BussinessCommon.ERROR_DATA_FILE, request);
 *                 }
 *                 MDC.clear();
 *             }
 *
 *             @Override
 *             public void onFailure(Exception e) {
 *                 MDC.setContextMap(mdcMap);
 *                 log.error("数据插入es出现异常，数据:{},异常信息为：",request.getDescription(), e);
 *                 writeLog(BussinessCommon.UNCOMMT_REQUST_DATA_FILE, request);
 *                 MDC.clear();
 *             }
 *         });
 */
