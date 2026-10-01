```MIS (Management Information System)```

``Quản lý cửa hàng sửa chữa xe ``

Dữ liệu
Chức năng //
Con người
Môi trường
Thiết bị

Một cửa hàng sửa chữa xe gắn máy, có nhiều thợ, các thợ được phân biệt với nhau qua mã thợ và có các thông tin mô tả như là họ tên, địa chỉ, số điện thoại, ...

Các thợ được chia thành từng nhóm, mỗi thợ sẽ thuộc vào 1 nhóm thợ, các nhóm sẽ có mã nhóm để phân biệt ngoài ra còn có tên nhóm và 1 thợ trong nhóm sẽ được cử làm trưởng nhóm.

Có nhiều công việc thực hiện sữa chữa, các công việc được phân qua mã công việc, có các thông tin mô tả như nội dụng, ...

Các công việc cũng thuộc 1 nhóm công việc, các nhóm phân biệt qua mã nhóm.
khách hàng mang xe đến sữa chữa sẽ có 1 hợp đồng sữa chữa xe, 1 hợp đồng chỉ sữa chữa cho 1 xe, và xe chỉ thuộc sở hữu của 1 khác hàng.

Các hợp đồng phân biệt qua số hợp đồng, ngoài ra còn có thông tin như là ngày kí hợp đồng, ngày thanh lý hợp đồng, tình trạng của hợp đồng, trị giá của hợp đồng.

Một công việc trên hợp đồng sữa chữa chỉ do 1 thợ chịu trách nhiệm chính, để xác định trả cho thợ. 

Hợp đồng có thể chi trả thành nhiều lần, nhiều lần sẽ được ghi nhận bởi phiếu thu, các phiếu thu được phân biệt qua số phiếu và có các thông tin mô tả như:
    ngày nộp
    họ tên người nộp
    số tiền nộp

``1. Xác định các thực thể, các thuộc tính khóa, mô tả thực thể ERD(entity relationship diagram)``

    `(1) Nhóm thợ`
        -Mã nhóm thợ (Primary Key)

    `(2) Thợ`
        -Mã thợ (Primary Key)

    `(3) Nhóm công việc`
        -Mã nhóm công việc (Primary Key)
    
    `(4) Công việc`
        -Mã công việc (Primary Key)
    
    `(5) Khách hàng`
        -Mã khách hàng (Primary Key)
    
    `(6) Xe`
        -Mã xe (Primary Key)
    
    `(7) Hợp đồng sữa xe`
        -Mã hợp đồng (Primary Key)
    
    `(8) Phiếu thu`
        -Mã phiếu thu (Primary Key)


    (1) -(1-n)- (2) //Thuộc nhóm
    (1) -(1-1)- (2) //Trưởng nhóm
    
     (3) -(1-n)- (4)
        //

    (5) -(1-n)- (6) -(1-n)- (7) -(1-n)- (8)
        //Sở hữu    //Hợp đồng  //Chi trả

   


``2. Xác định mối liên kết giữa các thực thể, từ đó đưa ra lược đề quan hệ thực thể kết hợp``

`(1) Nhóm thợ (Mã nhóm thợ, tên nhóm, ...)`
`(2) Thợ (mã thợ(PK), họ tên, địa chỉ, mã nhóm công việc (FK) ...)`
`(3) Nhóm công việc(Mã nhóm công việc(PK), tên nhóm công việc, ,...)`
`(4) Công việc (Mã công việc, tên công việc, độ khó, Mã nhóm công việc (FK) ...)`
`(5) Khách hàng (Mã khách hàng, tên khách hàng, ngày sinh, địa chỉ, số điện thoại, ...)`
`(6) Xe (mã xe, số xe, hãng xe, màu xe, mã khách hàng (FK), ...)`
`(7 Hợp đồng sữa xe(Mã hợp đồng, ngày ký, ngày thanh lý, điều kiện, giá, Số xe (FK) ...)`
`(8) Phiếu thu (Mã phiếu thu, số tiền, họ tên, ngày nộp, số hợp đồng (FK) ...)`
    RR
`(9) chi tiết hợp đồng sữa chữa xe ([Số hợp đồng, mã công việc] (PK), ma tho, khoán thợ)`
`(10) Khả năng ([ma tho, ma cong viec] (PK), ....)`


``3 ``
    Chuẩn hóa lược đồ về chuẩn số 3
``4``
    Trả lời 10 câu hỏi mình thích, viết bằng lamda, và link queue?
