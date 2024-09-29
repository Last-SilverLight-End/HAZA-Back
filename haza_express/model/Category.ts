export interface CategoryData {
  ID: number | string;
  Name: string;
}

export interface TopCategoryData extends CategoryData {
  Level : string | number;

}

// 예시: const로 객체를 생성할 때
const genreTopCategory: TopCategoryData = {
  ID: 1,
  Name: "Action",
  Level: "Top"
};

export default genreTopCategory;
