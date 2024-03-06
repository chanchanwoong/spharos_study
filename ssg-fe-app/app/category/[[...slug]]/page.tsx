export default function Page({params}: {params: {slug: string[]}}) {
    console.log(params.slug);
    params.slug == undefined ? console.log('Get Data of All Categorys') : console.log(`Category Page of Category: ${params.slug}`)
    return(
        <div>
            <h1>Category</h1>
            <p>카테고리 페이지!</p>
            <p>{params.slug}</p>
        </div>
    )
}