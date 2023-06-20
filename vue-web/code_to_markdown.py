'''
从项目中生成源代码文档，markdown格式
'''



def get_files_and_times_by_re(base, files_re):
  """
  通过re正则匹配获取所有名称符合正则的文件路径，并记录其拍摄时间

  Args:
      base (str): 起点路径
      files_re (str): 用以匹配文件名的正则表达式

  Returns:
      list: 匹配到的文件完整路径列表，和拍摄时间组成的列表
  """
  import re 
  import os
  paths = []
  all_r = list(os.walk(base))
  # dir_path路径名， dir_names在dir_path路径下的子目录名， files在dir_path路径下的文件名
  for dir_path, dir_names, file_names in all_r:
    for file_name in file_names:
      if re.match(files_re, file_name):
        # findall 输出列表，需要取出第一个元素
        date_time = re.findall(r"\d{4}-\d{2}-\d{2}T\d{2}_\d{2}_\d{2}", dir_path)[0]
        paths.append((os.path.join(dir_path, file_name), date_time))

  return paths

def get_files_by_re(base, files_re):
  """
  通过re正则匹配获取所有名称符合正则的文件路径

  Args:
      base (str): 起点路径
      files_re (str): 用以匹配文件名的正则表达式

  Returns:
      list: 匹配到的文件完整路径列表
  """
  import re 
  import os
  paths = []
  all_r = list(os.walk(base))
  # dir_path路径名， dir_names在dir_path路径下的子目录名， files在dir_path路径下的文件名
  for dir_path, dir_names, file_names in all_r:
    for file_name in file_names:
      if re.match(files_re, file_name):
        # findall 输出列表，需要取出第一个元素
        paths.append(os.path.join(dir_path, file_name))

  return paths

if __name__ == "__main__":
  import sys
  print(sys.argv[0])
  import os
  # temp = get_files_and_times_by_re(os.getcwd() + r"\All", "proc.jpg")
  # print(temp)
  print("-----------------")
  # paths = get_files_by_re(os.getcwd(), "^[\s\S]*\.java$")
  rootpath = os.getcwd()
  paths = get_files_by_re(rootpath, "^[\s\S]*\.vue$")
  file = open("temp.md", 'w', encoding='utf-8')
  file.write("# C） 前端代码\n\n")
  for i in paths:
    print(i)
    tempfile = open(i, 'r', encoding='utf-8')
    # 输出tempfile的内容
    # file.write(i + "\n" + "```java" + "\n" + tempfile.read() + "\n" + "```" + "\n")
    # 输出i相对于根目录的路径
    file.write("**" + i.replace(rootpath + "\\", "") + "**" + "\n\n" + "```vue" + "\n" + tempfile.read() + "\n" + "```" + "\n\n")
    tempfile.close() 
  file.close()




