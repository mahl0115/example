namespace java com.thrift.thrift

struct TOrder{
    1:i32 id,
    2:i32 orderId,
    3:string orderNumber,
    4:i32 userId,
    5:string title,
    6:string content,
    7:i32 status
}

service TOrderService {

   list<TOrder> getOrdersByUserId(1:i32 userId);

   TOrder getOrderByOrderNumber(1:string orderNumber);

   list<TOrder> getOrdersByStatus(1:i32 status);
}