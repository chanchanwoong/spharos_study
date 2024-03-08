export default function Layout({
    children,
    team,
    analytics,
} :{
    children: React.ReactNode;
    team: React.ReactNode;
    analytics: React.ReactNode;
}) {
    return(
        <div>
            {children}
            <div className="flex flex-row justify-between items-start">
                {analytics}
                {team}
            </div>
        </div>     
    )
}