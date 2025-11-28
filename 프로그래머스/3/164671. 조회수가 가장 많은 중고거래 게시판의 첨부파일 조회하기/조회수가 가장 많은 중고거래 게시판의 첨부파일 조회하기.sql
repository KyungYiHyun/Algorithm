select concat("/home/grep/src/", ugb.board_id,"/",ugf.file_id,ugf.file_name,ugf.file_ext) AS FILE_PATH
from used_goods_file ugf
join
(select board_id
from used_goods_board
where views =  (select max(views) from used_goods_board)) ugb
on ugf.board_id = ugb.board_id
order by ugf.file_id desc;