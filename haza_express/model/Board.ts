export interface BoardData {
  board_id: number;
  title: string;
  content: string;
  hit: number;
  created_date: string;
  modified_date: string;
  user_id: number;
  user_name: string;
  user_email: string;
  main_Category_Id?: string;
  mid_Category_Id?: string;
};