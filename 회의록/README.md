## **_💾 DB_**

> member
<pre>
 String userId        [pk]
 String userName      [NN]
 String userPw        [NN]
 String userEmail     [UQ]
 String userAddress   [NN]
 String userAddress_extra 
 String gender        [NN]
 String like          varchar(1000)
 DATE joinDate        now()
</pre>

> admin
<pre>


</pre>
 
> product
<pre>
p_num        int(11) NOT NULL,
p_name       varchar(50) COLLATE utf8_bin NOT NULL,
p_category   varchar(45) COLLATE utf8_bin NOT NULL,
p_option     varchar(100) COLLATE utf8_bin NOT NULL,
p_price      int(11) NOT NULL,
p_amount     int(11) NOT NULL,
p_image      varchar(1000) COLLATE utf8_bin NOT NULL,
best         varchar(45) COLLATE utf8_bin DEFAULT NULL,
p_date       date DEFAULT NULL,
ship_date    int(11) NOT NULL,
p_return_fee int(11) DEFAULT NULL,
</pre>
> goods_thumb

> basket
<pre>
b_num      int(11) NOT NULL
b_u_id     varchar(45) COLLATE utf8_bin NOT NULL
b_p_num    int(11) NOT NULL,
b_p_amount int(11) NOT NULL,
b_p_option varchar(100) COLLATE utf8_bin NOT NULL,
b_date     date NOT NULL,
</pre>

> board
<pre>
bo_num       int(11) [PK]
bo_u_id      varchar(45) NOT NULL,
bo_category  varchar(45) NOT NULL,
bo_subject   varchar(100) NOT NULL,
bo_content   varchar(10000) NOT NULL,
bo_readcount int(11) NOT NULL,
bo_re_ref    int(11) NOT NULL,
bo_re_lev    int(11) NOT NULL,
bo_re_seq    int(11) NOT NULL,
bo_updateDate date NOT NULL,
bo_p_num     varchar(45) DEFAULT NULL,
bo_p_image   varchar(1000) DEFAULT NULL,
</pre>

> order
<pre>
o_num       int(11) NOT NULL,
_d_num      varchar(45) COLLATE utf8_bin NOT NULL,
o_p_num     int(11) NOT NULL,
o_p_name    varchar(45) COLLATE utf8_bin NOT NULL,
o_p_amount  int(11) NOT NULL,
o_p_option  varchar(100) COLLATE utf8_bin NOT NULL,
o_u_id      varchar(45) COLLATE utf8_bin NOT NULL,
o_d_name    varchar(45) COLLATE utf8_bin NOT NULL,
o_d_add     varchar(45) COLLATE utf8_bin NOT NULL,
o_d_phone   varchar(45) COLLATE utf8_bin NOT NULL,
o_d_msg     varchar(200) COLLATE utf8_bin NOT NULL,
o_sum_money int(11) NOT NULL,
o_acc_type  varchar(45) COLLATE utf8_bin NOT NULL,
o_acc_payer varchar(45) COLLATE utf8_bin NOT NULL,
o_acc_date  date NOT NULL,
o_way_num   varchar(45) COLLATE utf8_bin NOT NULL,
o_date      date NOT NULL,
o_status    int(11) NOT NULL,
</pre>
