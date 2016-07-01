
import re
def map(filename, filedata):

    emit = dict()

    # Parse data
    r = re.compile('<\w*>|<\w*\s', re.IGNORECASE)
    tags = r.findall(filedata.read())
    for tag in tags:
        # Clense data
        tag = tag.replace('<', '')
        tag = tag.replace('>', '')
        tag = tag.strip()

        # Store data
        if tag != '':
            if tag in emit:
                emit[tag] += 1
            else:
                emit[tag] = 1
    return emit

def unshuffle(shuffled_data):
    sorted_data = dict()

    for tag_dict in shuffled_data:
        for tag in tag_dict:
            if tag in sorted_data:
                sorted_data[tag].append(tag_dict[tag])
            else:
                sorted_data[tag] = [tag_dict[tag]]
    return sorted_data

def reduce(sorted_data):
    reduced_data = dict()

    for tag in sorted_data:
        tag_sum = 0
        for value in sorted_data[tag]:
            tag_sum += value
        if tag in reduced_data:
            reduced_data[tag] += tag_sum
        else:
            reduced_data[tag] = tag_sum
    return reduced_data
