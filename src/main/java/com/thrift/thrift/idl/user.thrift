namespace java com.thrift.thrift

struct TUser{
    1:i32 id,
    2:i32 userId,
    3:string userName,
    4:string password,
    5:i32 age
}

service TUserService {
  bool login(1:TUser tuser)
}