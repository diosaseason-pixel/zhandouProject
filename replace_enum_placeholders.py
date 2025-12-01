#!/usr/bin/env python
# -*- coding: utf-8 -*-

import re
import os

def read_proto_id_file(file_path):
    """读取CSProtoId.txt文件并构建协议名称到ID值的映射"""
    proto_map = {}
    print(f"正在读取协议ID文件: {file_path}")
    
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            for line_num, line in enumerate(f, 1):
                line = line.strip()
                if not line:
                    continue
                
                # 解析格式如 "CS_HEART_CLEAR_RANDOMPROP_REQ = 10240;"
                parts = line.split('=')
                if len(parts) == 2:
                    proto_name = parts[0].strip()
                    value_str = parts[1].strip()
                    if value_str.endswith(';'):
                        value_str = value_str[:-1]
                    
                    try:
                        value = int(value_str)
                        proto_map[proto_name] = value
                        if line_num <= 5 or len(proto_map) <= 5:
                            print(f"已解析: {proto_name} = {value}")
                    except ValueError:
                        print(f"警告: 无法解析协议ID值 (行 {line_num}): {line}")
    except Exception as e:
        print(f"读取协议ID文件时出错: {e}")
        
    print(f"成功加载协议ID映射，共 {len(proto_map)} 条记录")
    return proto_map

def replace_enum_placeholders(input_file_path, output_file_path, proto_map):
    """替换SCmd.java中的enum("CS_XX")占位符"""
    print(f"正在处理SCmd文件: {input_file_path}")
    print(f"输出文件路径: {output_file_path}")
    
    try:
        # 逐行读取并处理，这样可以更好地处理行尾的分号
        with open(input_file_path, 'r', encoding='utf-8') as f_in:
            lines = f_in.readlines()
        
        new_lines = []
        replaced_count = 0
        pattern = re.compile(r'enum\("([^"]+)"\)')
        
        for line in lines:
            matches = list(pattern.finditer(line))
            if matches:
                # 找到了占位符
                new_line = line
                for match in reversed(matches):  # 从后往前替换，避免位置偏移
                    proto_name = match.group(1)
                    if proto_name in proto_map:
                        replaced_count += 1
                        value = proto_map[proto_name]
                        if replaced_count <= 5:
                            print(f"替换: {proto_name} => {value}")
                        
                        # 替换占位符，确保有分号结尾
                        replacement = str(value)
                        new_line = new_line[:match.start()] + replacement + new_line[match.end():]
                        
                        # 检查行尾是否有分号，如果没有则添加
                        stripped_line = new_line.rstrip()
                        if not stripped_line.endswith(';') and not stripped_line.endswith('{') and not stripped_line.endswith('}'):
                            if '//' in stripped_line:  # 处理有注释的情况
                                comment_pos = stripped_line.find('//')
                                new_line = stripped_line[:comment_pos] + '; ' + stripped_line[comment_pos:] + '\n'
                            else:
                                new_line = stripped_line + ';\n'
                    else:
                        print(f"警告: 未找到协议 \"{proto_name}\" 对应的ID值")
                
                new_lines.append(new_line)
            else:
                # 没有占位符，保持原样
                new_lines.append(line)
        
        # 写入替换后的内容到输出文件
        with open(output_file_path, 'w', encoding='utf-8') as f_out:
            f_out.writelines(new_lines)
            
        print(f"处理完成: 替换了 {replaced_count} 个占位符")
        
    except Exception as e:
        print(f"处理文件时出错: {e}")

def main():
    # 文件路径配置
    proto_id_file = r"C:\Users\admin\IdeaProjects\zmxs\common\src\main\java\com\game\cmd\CSProtoId.txt"
    scmd_file = r"C:\Users\admin\IdeaProjects\zmxs\common\src\main\java\com\game\cmd\SCmd.java"
    output_file = r"C:\Users\admin\IdeaProjects\zmxs\common\src\main\java\com\game\cmd\SCmd_updated.java"
    
    # 确保输出文件的目录存在
    os.makedirs(os.path.dirname(output_file), exist_ok=True)
    
    # 检查源文件是否存在
    if not os.path.exists(proto_id_file):
        print(f"错误: 找不到协议ID文件: {proto_id_file}")
        return
    
    if not os.path.exists(scmd_file):
        print(f"错误: 找不到SCmd文件: {scmd_file}")
        return
    
    # 读取CSProtoId.txt并构建映射
    proto_map = read_proto_id_file(proto_id_file)
    
    # 替换SCmd.java中的占位符
    replace_enum_placeholders(scmd_file, output_file, proto_map)
    
    # 确认输出文件是否生成
    if os.path.exists(output_file):
        print(f"替换完成，已将结果输出到: {output_file}")
    else:
        print(f"警告: 未能生成输出文件: {output_file}")

if __name__ == "__main__":
    main()