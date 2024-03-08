import { NextAuthOptions } from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";
import KakaoProvider from "next-auth/providers/kakao";

export const options: NextAuthOptions = {
    providers: [      // 뭘로 로그인할거냐 결정
        CredentialsProvider({
            name: "Credentials",
            credentials: {
                username: { label: "Username", type: "text" },
                password: { label: "Password", type: "password" },
            },
            async authorize(credentials, req) {
                // 서버와 통신하여 로그인 처리
                return null;
            }
        }),
        KakaoProvider({
            clientId: process.env.KAKAO_CLIENT_ID || "",
            clientSecret: process.env.KAKAO_CLIENT_SECRET || "",
        })
    ],
    callbacks: {},      // 넘어오는 값에 대한 관리
    pages: {      // NextAuth에서 제공해주는 기본 로그인, 로그아웃 페이지를 안 쓰고 사용할 페이지 연결
        signIn: "/login",
        error: "/auth_error",
    },
}