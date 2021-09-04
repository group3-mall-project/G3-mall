## **_💾 DB_**

> member
<pre>
u_id      varchar(45)  PK
u_pw      varchar(45)  NN
u_name    varchar(45)  NN
u_email   varchar(100) UQ
u_phone   varchar(45)  NN
u_address varchar(45)  NN
u_gender  varchar(45)  NN
u_birth   int(11)      NN
u_like    varchar(45)  
joindate  date         NN now()
</pre>

> admin
<pre>

</pre>
 
> product
<pre>
p_num        int(11)       PK
p_name       varchar(50)   NN
p_category   varchar(45)   NN
p_option     varchar(100)  NN
p_price      int(11)       NN
p_amount     int(11)       NN
p_image      varchar(1000) NN
best         varchar(45)
p_date       date          NN now()
ship_date    int(11)       NN
p_return_fee int(11)       NN
</pre>
> goods_thumb
?

> basket
<pre>
b_num      int(11)      NN
b_u_id     varchar(45)  NN
b_p_num    int(11)      NN
b_p_amount int(11)      NN
b_p_option varchar(100) NN
b_date     date         NN now()
</pre>

> board
<pre>
bo_num       int(11)        PK
bo_u_id      varchar(45)    NN
bo_category  varchar(45)    NN
bo_subject   varchar(100)   NN
bo_content   varchar(10000) NN
bo_readcount int(11)        NN
bo_re_ref    int(11)        NN
bo_re_lev    int(11)        NN
bo_re_seq    int(11)        NN
bo_updateDate date          NN now()
bo_p_num     varchar(45)    
bo_p_image   varchar(1000)  NN
</pre>

> order
<pre>
o_num       int(11)         PK
_d_num      varchar(45)     NN
o_p_num     int(11)         NN
o_p_name    varchar(45)     NN
o_p_amount  int(11)         NN
o_p_option  varchar(100)    NN
o_u_id      varchar(45)     NN
o_d_name    varchar(45)     NN
o_d_add     varchar(45)     NN
o_d_phone   varchar(45)     NN
o_d_msg     varchar(200)    NN
o_sum_money int(11)         NN
o_acc_type  varchar(45)     NN
o_acc_payer varchar(45)     NN
o_acc_date  date            NN now()
o_way_num   varchar(45)     NN now()
o_date      date            NN now
o_status    int(11)         NN
</pre>
