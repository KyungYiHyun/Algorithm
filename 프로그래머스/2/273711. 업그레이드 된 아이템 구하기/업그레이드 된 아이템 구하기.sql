select ii.item_id, ii.item_name, ii.rarity
from item_info ii join 
(select item_id
from item_tree
where parent_item_id in (
    select item_id
    from item_info
    where rarity = 'RARE'
)) it on ii.item_id = it.item_id 
order by ii.item_id desc;