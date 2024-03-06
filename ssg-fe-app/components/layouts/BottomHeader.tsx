import { mainNaviMenuData } from '@/lib/initData'
import { NavType } from '@/types/navType'
import Link from 'next/link'
import React from 'react'

function BottomHeader() {
  return (
    <nav className='flex flex-col justify-center'>
      <ul className="flex flex-row">
        {
          mainNaviMenuData.map((menu: NavType) => {
            return (
              <li key={menu.id} className='px-[12px] py-[10px] text-[15px]'>
                <Link href={menu.url}>
                  {menu.title}
                </Link>
              </li>
            )
          })
        }
      </ul>
    </nav>
  )
}

export default BottomHeader