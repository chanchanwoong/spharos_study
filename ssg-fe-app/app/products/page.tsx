import Link from "next/link";

export default function Page() {

    // const productListData = await getProductListData();
    const productListData = [
        {
            id: 1,
            productId: 15,
            name: 'product 1',
            productImgUrl: 'http://~~'
        },
        {
            id: 2,
            productId: 20,
            name: 'product 2',
            productImgUrl: 'http://~~'
        },
        {
            id: 3,
            productId: 25,
            name: 'product 3',
            productImgUrl: 'http://~~'
        }
    ];


    return (
        <div>
            <h1>Products</h1>
            <p>This is products Page</p>
            <div>
                <ul>
                    {
                        productListData.map((product) => {
                            return (
                                <li key={product.id}>
                                    <Link href={`/products/detail/${product.productId}`}>
                                        <p>{product.name}</p>
                                    </Link>
                                </li>
                            );
                        })
                    }
                </ul>
            </div>
        </div>
    )
}