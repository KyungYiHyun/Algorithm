with temp as (select *
from fish_info
where (fish_type,length) in 
(select f.fish_type, max(f.length) as max_length
from fish_info f
group by f.fish_type))

select t.id, fni.fish_name, t.length
from temp t
join fish_name_info fni on t.fish_type = fni.fish_type
order by t.id

