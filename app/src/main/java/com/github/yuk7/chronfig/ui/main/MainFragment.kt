package com.github.yuk7.chronfig.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.yuk7.chronfig.R
import com.github.yuk7.chronfig.databinding.FragmentMainBinding
import com.github.yuk7.chronfig.models.ItemModelInterface
import com.github.yuk7.chronfig.models.SpecialItemModel
import com.github.yuk7.chronfig.models.UserConfigModel
import com.topjohnwu.superuser.Shell
import com.topjohnwu.superuser.io.SuFile
import com.topjohnwu.superuser.io.SuFileOutputStream
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var controller: MainController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

        controller = MainController(
            object : MainController.Listener {
                override fun onClickItem(index: Int, item: ItemModelInterface) {
                    if (item is UserConfigModel) {
                        GlobalScope.launch {
                            Shell.su("echo 0 > /sys/fs/selinux/enforce").submit()
                            val file = SuFile("/data/local/chrome-command-line")
                            file.createNewFile()
                            val fos = SuFileOutputStream(file.path)
                            fos.write(item.command!!.toByteArray())
                            fos.flush()
                        }
                    } else {
                        val file = SuFile("/data/local/chrome-command-line")
                        file.delete()
                    }
                }
            }
        )
        binding.recyclerView.setController(controller)

        mainViewModel.add(SpecialItemModel(name = "Default"))
        mainViewModel.add(UserConfigModel(id = 0, name = "Chrome on Linux", isUseCmd = true, ua = null, command = "chrome --user-agent=\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36\""))
        mainViewModel.add(UserConfigModel(id = 1, name = "Windows Phone", isUseCmd = true, ua = null, command = "chrome --user-agent=\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36\""))
        mainViewModel.add(UserConfigModel(id = 1, name = "Chrome Android GoogleBot", isUseCmd = true, ua = null, command = "chrome --user-agent=\"Mozilla/5.0 (Linux; Android 6.0.1; Nexus 5X Build/MMB29P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Mobile Safari/537.36 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)\""))
        mainViewModel.add(UserConfigModel(id = 1, name = "Windows Mobile 6.5", isUseCmd = true, ua = null, command = "chrome --user-agent=\"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 8.12; MSIEMobile 6.5) T-01B\""))
        mainViewModel.list.observe(viewLifecycleOwner, Observer(controller::setData))

    }

}