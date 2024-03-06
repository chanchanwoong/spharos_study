// API을 통해 통신할 데이터 타입을 미리 정하기
// id는 프론트에서 사용할 인덱스 용도로 백엔드에서 필수로 보내줘야 한다.
export interface ProductDataType {
    id: number;
    productId: string;
    name: string;
    productImgUrl: string;
}